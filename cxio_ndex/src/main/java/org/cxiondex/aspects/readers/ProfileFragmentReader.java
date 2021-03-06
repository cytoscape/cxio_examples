package org.cxiondex.aspects.readers;

import java.io.IOException;
import org.cxio.aspects.readers.AbstractFragmentReader;
import org.cxio.aspects.readers.ParserUtils;
import org.cxio.core.interfaces.AspectElement;
import org.cxiondex.aspects.datamodels.ProfileElement;

import com.fasterxml.jackson.databind.node.ObjectNode;

public class ProfileFragmentReader extends AbstractFragmentReader {
   
    public static ProfileFragmentReader createInstance() {
        return new ProfileFragmentReader();
    }

    private ProfileFragmentReader() {
        super();
    }

    @Override
    public String getAspectName() {
        return ProfileElement.NAME;
    }

    @Override
    public AspectElement readElement(ObjectNode o) throws IOException {
        final String name = ParserUtils.getTextValueRequired(o, ProfileElement.PROFILE_NAME);
        final String desc = ParserUtils.getTextValueRequired(o, ProfileElement.PROFILE_DESC);
        return new ProfileElement(name, desc);
    }
}
