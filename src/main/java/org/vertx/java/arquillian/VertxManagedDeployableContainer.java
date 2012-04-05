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

import org.jboss.arquillian.container.spi.client.container.DeploymentException;
import org.jboss.arquillian.container.spi.client.container.LifecycleException;
import org.jboss.arquillian.container.spi.client.protocol.ProtocolDescription;
import org.jboss.arquillian.container.spi.client.protocol.metadata.ProtocolMetaData;
import org.jboss.shrinkwrap.api.Archive;

/**
 * 
 * 
 * @author <a href="mailto:alr@jboss.org">Andrew Lee Rubinger</a>
 */
public final class VertxManagedDeployableContainer extends
    VertxCommonDeployableContainer<VertxManagedContainerConfiguration> {

    /**
     * {@inheritDoc}
     * 
     * @see org.jboss.arquillian.container.spi.client.container.DeployableContainer#deploy(org.jboss.shrinkwrap.api.Archive)
     */
    @Override
    public ProtocolMetaData deploy(final Archive<?> archive) throws DeploymentException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.jboss.arquillian.container.spi.client.container.DeployableContainer#getConfigurationClass()
     */
    @Override
    public Class<VertxManagedContainerConfiguration> getConfigurationClass() {
        return VertxManagedContainerConfiguration.class;
    }

    @Override
    public ProtocolDescription getDefaultProtocol() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void start() throws LifecycleException {

        final String vertxHome = new File(this.getConfiguration().getVertxHome()).getAbsolutePath();
        final String vertxExec = vertxHome + File.separatorChar + "bin";

    }

    @Override
    public void stop() throws LifecycleException {
        // TODO Auto-generated method stub

    }

    @Override
    public void undeploy(Archive<?> arg0) throws DeploymentException {
        // TODO Auto-generated method stub

    }

}
