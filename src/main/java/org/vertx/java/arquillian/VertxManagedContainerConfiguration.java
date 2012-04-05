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
package org.vertx.java.arquillian;

import java.io.File;

import org.jboss.arquillian.container.spi.ConfigurationException;
import org.jboss.arquillian.container.spi.Container;

/**
 * Represents the configuration for Vert.x Managed {@link Container}s
 * 
 * @author <a href="mailto:alr@jboss.org">Andrew Lee Rubinger</a>
 */
public final class VertxManagedContainerConfiguration extends VertxCommonContainerConfiguration {

    /**
     * Path to the VertX installation
     */
    private String vertxHome;

    /**
     * Whether or not to enable assertions
     */
    private boolean enableAssertions;

    /**
     * {@inheritDoc}
     * 
     * @see org.jboss.arquillian.container.spi.client.container.ContainerConfiguration#validate()
     */
    @Override
    public void validate() throws ConfigurationException {
        // Call super
        super.validate();

        // Ensure VertX Home exists and is a directory
        final String vertxHome = this.getVertxHome();
        if (vertxHome == null || vertxHome.length() == 0) {
            throw new ConfigurationException("vertxHome must be specified");
        }
        final File vertxHomeFile = new File(vertxHome);
        if (!vertxHomeFile.exists()) {
            throw new ConfigurationException("Specified vertxHome does not exist: " + vertxHomeFile.getAbsolutePath());
        }
        if (!vertxHomeFile.isDirectory()) {
            throw new ConfigurationException("Specified vertxHome is not a directory: "
                + vertxHomeFile.getAbsolutePath());
        }
    }

    public String getVertxHome() {
        return vertxHome;
    }

    public void setVertxHome(final String vertxHome) {
        this.vertxHome = vertxHome;
    }

    public boolean isEnableAssertions() {
        return enableAssertions;
    }

    public void setEnableAssertions(boolean enableAssertions) {
        this.enableAssertions = enableAssertions;
    }

}
