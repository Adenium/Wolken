package org.wolkenproject.papaya.compiler;

import org.wolkenproject.utils.VarInt;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public enum AccessModifier {
    None,
    PublicAccess,
    ProtectedAccess,
    PrivateAccess,

    ReadOnly,
    ;

    public static void write(AccessModifier accessModifier, OutputStream stream) throws IOException {
        switch (accessModifier) {
            case None:
                VarInt.writeCompactUInt32(0, false, stream);
                break;
            case PublicAccess:
                VarInt.writeCompactUInt32(1, false, stream);
                break;
            case ProtectedAccess:
                VarInt.writeCompactUInt32(2, false, stream);
                break;
            case PrivateAccess:
                VarInt.writeCompactUInt32(3, false, stream);
                break;
            case ReadOnly:
                VarInt.writeCompactUInt32(4, false, stream);
                break;
        }
    }

    public static AccessModifier read(InputStream stream) throws IOException {
        int mod = 0;
        switch (mod = VarInt.readCompactUInt32(false, stream)) {
            case 0:
                return None;
            case 1:
                return PublicAccess;
            case 2:
                return ProtectedAccess;
            case 3:
                return PrivateAccess;
            case 4:
                return ReadOnly;
        }

        throw new IOException("invalid value '"+mod+"' for 'AccessModifier'");
    }
}