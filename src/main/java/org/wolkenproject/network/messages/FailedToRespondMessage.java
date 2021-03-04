package org.wolkenproject.network.messages;

import org.wolkenproject.exceptions.WolkenException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FailedToRespondMessage extends ResponseMessage {
    public static final class ReasonFlags {
        public static final long
        NoReasonSpecified = 0,
        CouldNotFindRequestedData = 1 << 1;
    }

    private long reasonFlags;

    public FailedToRespondMessage(int version, long reasonFlags, byte[] uniqueMessageIdentifier) {
        super(version, uniqueMessageIdentifier);
        this.reasonFlags = reasonFlags;
    }

    @Override
    public void writeContents(OutputStream stream) throws IOException, WolkenException {
    }

    @Override
    public void readContents(InputStream stream) throws IOException, WolkenException {
    }

    @Override
    public <Type> Type getPayload() {
        return null;
    }

    @Override
    public boolean containsResponse() {
        return false;
    }

    @Override
    public boolean containsFullResponse() {
        return false;
    }

    @Override
    public int getResponseType() {
        return 0;
    }
}
