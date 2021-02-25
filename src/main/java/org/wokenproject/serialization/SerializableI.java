package org.wokenproject.serialization;

import org.wokenproject.core.Context;

import java.io.*;

public abstract class SerializableI {
    public abstract void write(OutputStream stream);
    public abstract void read(InputStream stream);

    public byte[] asByteArray() throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        write(outputStream);
        outputStream.flush();
        outputStream.close();

        return outputStream.toByteArray();
    }

    public <Type extends SerializableI> Type makeCopy() throws IOException {
        byte array[] = asByteArray();
        BufferedInputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(array));
        Type t = Context.getInstance().getSerialFactory().fromStream(inputStream);
        inputStream.close();

        return t;
    }

    public abstract <Type extends SerializableI> Type newInstance(Object ...object);
}
