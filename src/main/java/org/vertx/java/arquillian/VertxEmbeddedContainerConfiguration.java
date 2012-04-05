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

import org.jboss.arquillian.container.spi.ConfigurationException;
import org.jboss.arquillian.container.spi.Container;

/**
 * Represents the configuration for Vert.x Embedded {@link Container}s
 * 
 * @author <a href="mailto:alr@jboss.org">Andrew Lee Rubinger</a>
 */
public final class VertxEmbeddedContainerConfiguration extends VertxCommonContainerConfiguration {

    /**
     * {@inheritDoc}
     * 
     * @see org.jboss.arquillian.container.spi.client.container.ContainerConfiguration#validate()
     */
    @Override
    public void validate() throws ConfigurationException {
        // Call super
        super.validate();
    }

}
