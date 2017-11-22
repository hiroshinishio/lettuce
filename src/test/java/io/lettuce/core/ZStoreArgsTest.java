/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.lettuce.core;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import io.lettuce.core.codec.StringCodec;
import io.lettuce.core.protocol.CommandArgs;

/**
 * @author Mark Paluch
 */
public class ZStoreArgsTest {

    @Test
    public void shouldRenderWeights() {

        CommandArgs<String, String> args = new CommandArgs<>(StringCodec.UTF8);
        ZStoreArgs.Builder.weights(1, 2, 3).build(args);

        assertThat(args.toString()).contains("WEIGHTS");
    }

    @Test
    public void shouldOmitWeights() {

        CommandArgs<String, String> args = new CommandArgs<>(StringCodec.UTF8);
        ZStoreArgs.Builder.weights().build(args);

        assertThat(args.toString()).doesNotContain("WEIGHTS");
    }
}
