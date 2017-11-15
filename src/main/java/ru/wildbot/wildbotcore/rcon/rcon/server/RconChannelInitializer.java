/*
 * Copyright 2017 Peter P. (JARvis PROgrammer)
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

package ru.wildbot.wildbotcore.rcon.rcon.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ru.wildbot.wildbotcore.console.logging.Tracer;

@RequiredArgsConstructor
public class RconChannelInitializer extends ChannelInitializer {
    @NonNull
    private final String key;

    @Override
    protected void initChannel(Channel channel) throws Exception {
        Tracer.info("Initialising channel for RCON handling");
        channel.pipeline().addLast("framer", new RconFrameHandler());
        channel.pipeline().addLast("handler", new RconHandler(key));
    }
}
