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

import org.jboss.arquillian.container.spi.client.container.DeployableContainer;
import org.jboss.arquillian.container.spi.client.container.DeploymentException;
import org.jboss.shrinkwrap.descriptor.api.Descriptor;

/**
 * 
 * 
 * @author <a href="mailto:alr@jboss.org">Andrew Lee Rubinger</a>
 */
public abstract class VertxCommonDeployableContainer<CONFIG extends VertxCommonContainerConfiguration> implements
    DeployableContainer<CONFIG> {

    private static final String MSG_UNSUPPORTED_DESCCRIPTOR_DEPLOYMENT = "Vertx does not support deployment of "
        + Descriptor.class.getSimpleName() + " types";
    
    private CONFIG configuration;
    
    /**
     * {@inheritDoc}
     * @see org.jboss.arquillian.container.spi.client.container.DeployableContainer#setup(org.jboss.arquillian.container.spi.client.container.ContainerConfiguration)
     */
    @Override
    public void setup(final CONFIG config) {
        this.configuration = config;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.jboss.arquillian.container.spi.client.container.DeployableContainer#deploy(org.jboss.shrinkwrap.descriptor.api.Descriptor)
     */
    @Override
    public void deploy(final Descriptor arg0) throws DeploymentException {
        throw new UnsupportedOperationException(MSG_UNSUPPORTED_DESCCRIPTOR_DEPLOYMENT);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.jboss.arquillian.container.spi.client.container.DeployableContainer#undeploy(org.jboss.shrinkwrap.descriptor.api.Descriptor)
     */
    @Override
    public void undeploy(Descriptor arg0) throws DeploymentException {
        throw new UnsupportedOperationException(MSG_UNSUPPORTED_DESCCRIPTOR_DEPLOYMENT);
    }

    /**
     * Returns the configuration for this container
     * @return
     */
    CONFIG getConfiguration() {
        return configuration;
    }
}
