/*
 * Copyright 2021 DataCanvas
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

package io.dingodb.expr.runtime.op.string;

import io.dingodb.expr.annotations.Operators;
import org.checkerframework.checker.nullness.qual.NonNull;

@Operators
abstract class Substr3Fun extends TertiaryStringIntIntFun {
    public static final String NAME = "SUBSTR";

    private static final long serialVersionUID = -5730776211565201950L;

    static @NonNull String substr(@NonNull String value0, int start, int end) {
        if (start < 0) {
            start = 0;
        }
        if (start == 0) {
            return end >= value0.length() ? value0 : value0.substring(start, end);
        }
        return end >= value0.length() ? value0.substring(start) : value0.substring(start, end);
    }

    @Override
    public final @NonNull String getName() {
        return NAME;
    }
}
