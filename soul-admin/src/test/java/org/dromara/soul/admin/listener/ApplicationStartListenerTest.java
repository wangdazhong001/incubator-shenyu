/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.dromara.soul.admin.listener;

import org.dromara.soul.admin.AbstractSpringIntegrationTest;
import org.dromara.soul.admin.utils.SoulDomain;
import org.dromara.soul.common.utils.IpUtils;
import org.junit.Test;
import org.springframework.boot.web.server.LocalServerPort;
import static org.junit.Assert.assertEquals;

/**
 * Test case for {@link ApplicationStartListener}.
 *
 * @author magicalxiaochen
 */
public final class ApplicationStartListenerTest extends AbstractSpringIntegrationTest {

    @LocalServerPort
    private Integer port;

    @Test
    public void testOnApplicationEvent() {
        String host = IpUtils.getHost();
        String expectedPath = "http://" + String.join(":", host, String.valueOf(port));
        assertEquals(expectedPath, SoulDomain.getInstance().getHttpPath());
    }
}