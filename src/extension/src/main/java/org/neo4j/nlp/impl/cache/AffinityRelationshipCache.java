package org.neo4j.nlp.impl.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.List;

/**
 * Copyright (C) 2014 Kenny Bastani
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
public class AffinityRelationshipCache extends RelationshipCache {

    public static final Cache<Long, List<Long>> relationshipCache = CacheBuilder.newBuilder().maximumSize(20000000).build();
    private final String relationshipType;
    private final String relationshipAggregateKey;

    public AffinityRelationshipCache()
    {
        this.relationshipType = "HAS_AFFINITY";
        this.relationshipAggregateKey = "affinity";
    }

    @Override
    public Cache<Long, List<Long>> getRelationshipCache() {
        return relationshipCache;
    }

    @Override
    protected String getRelationshipAggregateKey() {
        return relationshipAggregateKey;
    }

    @Override
    protected String getRelationshipType() {
        return relationshipType;
    }
}
