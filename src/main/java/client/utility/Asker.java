package client.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Asker {
    private BufferedReader reader;

    public Asker(InputStream stream) {
        this.reader = new BufferedReader(new InputStreamReader(stream));
    }

    private AskerType checkReaderType(InputStream stream){
//        if (stream.equals){
//            return AskerType.FILE;
//        }
        return null;
    }
}
