/*
 * Licensed to Metamarkets Group Inc. (Metamarkets) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. Metamarkets licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package io.druid.segment.loading;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.druid.segment.QueryableIndex;
import io.druid.segment.Segment;
import io.druid.timeline.DataSegment;

import java.io.File;
import java.io.IOException;

/**
 * Factory that loads segment files from the disk and creates {@link Segment} object
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", defaultImpl = MMappedQueryableSegmentizerFactory.class)
public interface SegmentizerFactory
{
  public Segment factorize(DataSegment segment, File parentDir) throws SegmentLoadingException;

  public QueryableIndex loadIndex(File parentDir) throws IOException;
}
