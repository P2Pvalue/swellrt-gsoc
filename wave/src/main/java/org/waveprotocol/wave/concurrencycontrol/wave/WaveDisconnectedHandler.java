/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.waveprotocol.wave.concurrencycontrol.wave;

import org.waveprotocol.wave.concurrencycontrol.common.CorruptionDetail;

import org.waveprotocol.wave.model.id.WaveId;

/**
 * A handler for wave disconnection. A wave becomes disconnected when the
 * concurrency control reconnection logic fails, such as server-side error or
 * excessive retries. Manual reconnection in the future may succeed.
 *
 * TODO(anorth): make multiplexer externally reconnectable.
 *
 * @author anorth@google.com (Alex North)
 */
public interface WaveDisconnectedHandler {
  /**
   * Called when a wave becomes disconnected and reconnection fails. The
   * wave view is no longer usable.
   *
   * @param waveId the disconnected wave
   */
  void onWaveDisconnected(WaveId waveId, CorruptionDetail detail);
}
