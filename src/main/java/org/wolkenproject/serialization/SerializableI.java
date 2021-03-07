package org.wolkenproject.serialization;

import org.wolkenproject.core.Context;
import org.wolkenproject.exceptions.WolkenException;
import org.wolkenproject.utils.HashUtil;
import org.wolkenproject.utils.Utils;

import java.io.*;

public abstract class SerializableI {
    public void serialize(OutputStream stream) throws IOException {
        Utils.writeInt(getSerialNumber(), stream);
        byte content[] = asByteArray();
        Utils.writeInt(content.length, stream);
        stream.write(content);
    }

    public abstract void write(OutputStream stream) throws IOException, WolkenException;
    public abstract void read(InputStream stream) throws IOException, WolkenException;

    public byte[] asByteArray() {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            write(outputStream);
            outputStream.flush();
            outputStream.close();

            return outputStream.toByteArray();
        } catch (IOException | WolkenException e) {
            return null;
        }
    }

    public byte[] asSerializedArray() {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            serialize(outputStream);
            outputStream.flush();
            outputStream.close();

            return outputStream.toByteArray();
        } catch (IOException e) {
            return null;
        }
    }

    public <Type extends SerializableI> Type makeCopy() throws IOException, WolkenException {
        byte array[] = asSerializedArray();
        BufferedInputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(array));
        Type t = Context.getInstance().getSerialFactory().fromStream(inputStream);
        inputStream.close();

        return t;
    }

    public abstract <Type extends SerializableI> Type newInstance(Object... object) throws WolkenException;

    public byte[] checksum() {
        return HashUtil.hash160(asByteArray());
    }

    public abstract int getSerialNumber();
}