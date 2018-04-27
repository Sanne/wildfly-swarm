package org.wildfly.swarm.infinispan.test;

/**
 * Copyright 2015-2016 Red Hat, Inc, and individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.wildfly.swarm.arquillian.DefaultDeployment;

import static org.junit.Assert.assertNotNull;

/**
 * @author Heiko Braun
 */
@RunWith(Arquillian.class)
@DefaultDeployment(
        testable = false,
        type = DefaultDeployment.Type.WAR
)
public class Swarm551Test {

    @Test
    public void testAccess() throws IOException {
        String response = IOUtils.toString(new URL("http://localhost:8080"), Charset.forName("UTF-8"));
        response = response.trim();

        UUID uuid = UUID.fromString(response);
        assertNotNull(uuid);
    }

}