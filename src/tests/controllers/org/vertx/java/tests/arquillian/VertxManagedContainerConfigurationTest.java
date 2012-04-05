/*
 * Copyright 2011-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.vertx.java.tests.arquillian;

import java.io.File;

import org.jboss.arquillian.container.spi.ConfigurationException;
import org.junit.Before;
import org.junit.Test;
import org.vertx.java.arquillian.VertxManagedContainerConfiguration;

/**
 * Unit tests asserting the {@link VertxManagedContainerConfiguration} is working as expected
 * 
 * @author <a href="mailto:alr@jboss.org">Andrew Lee Rubinger</a>
 */
public class VertxManagedContainerConfigurationTest {

    /**
     * Configration newly-initialized for each test
     */
    private VertxManagedContainerConfiguration config;

    @Before
    public void createNewInstance() {
        config = new VertxManagedContainerConfiguration();
    }

    @Test(expected = ConfigurationException.class)
    public void shouldNotAllowNullVertxHome() {
        this.validateAndLogConfigurationException();
    }

    @Test(expected = ConfigurationException.class)
    public void shouldNotAllowEmptyVertxHome() {
        config.setVertxHome("");
        this.validateAndLogConfigurationException();
    }

    @Test(expected = ConfigurationException.class)
    public void shouldNotAllowNonexistantVertxHome() {
        config.setVertxHome("/path/to/fake/dir");
        this.validateAndLogConfigurationException();
    }

    @Test(expected = ConfigurationException.class)
    public void shouldNotAllowNondirectoryVertxHome() {
        final String className = this.getClass().getName().replace('.', File.separatorChar) + ".class";
        config.setVertxHome(this.getClass().getProtectionDomain().getCodeSource().getLocation().getFile() + className);
        this.validateAndLogConfigurationException();
    }

    @Test
    public void shouldValidate() {
        // Set VertxHome to a valid directory
        config.setVertxHome(this.getClass().getProtectionDomain().getCodeSource().getLocation().getFile());
        this.validateAndLogConfigurationException();
    }

    private void validateAndLogConfigurationException() throws ConfigurationException {
        try {
            config.validate();
        } catch (final ConfigurationException e) {
            System.out.println("Got " + ConfigurationException.class.getSimpleName() + ": " + e.getMessage());
            throw e;
        }
    }

}
