package com.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author G
 * @create 2023-03-10 2:22 AM
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
