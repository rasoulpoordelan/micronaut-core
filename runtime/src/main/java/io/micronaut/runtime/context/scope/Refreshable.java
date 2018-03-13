/*
 * Copyright 2017 original authors
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
package io.micronaut.runtime.context.scope;

import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Type;
import io.micronaut.runtime.context.scope.refresh.RefreshInterceptor;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Type;
import io.micronaut.runtime.context.scope.refresh.RefreshInterceptor;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * <p>A custom {@link javax.inject.Scope} that allows target beans to be refreshed</p>
 *
 * @author Graeme Rocher
 * @since 1.0
 */
@ScopedProxy
@Documented
@Retention(RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Type(RefreshInterceptor.class)
@Bean
public @interface Refreshable {

    /**
     * @return The key prefixes that should cause this bean to be refreshed
     */
    String[] value() default {};
}