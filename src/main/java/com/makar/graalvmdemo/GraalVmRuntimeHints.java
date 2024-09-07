package com.makar.graalvmdemo;

import static org.springframework.aot.hint.MemberCategory.DECLARED_FIELDS;
import static org.springframework.aot.hint.MemberCategory.INVOKE_DECLARED_CONSTRUCTORS;
import static org.springframework.aot.hint.MemberCategory.INVOKE_DECLARED_METHODS;
import static org.springframework.aot.hint.MemberCategory.INVOKE_PUBLIC_CONSTRUCTORS;
import static org.springframework.aot.hint.MemberCategory.INVOKE_PUBLIC_METHODS;
import static org.springframework.aot.hint.MemberCategory.PUBLIC_FIELDS;

import com.amazonaws.serverless.proxy.model.HttpApiV2ProxyRequest;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;

public class GraalVmRuntimeHints implements RuntimeHintsRegistrar {

    @Override
    public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
        hints.reflection().registerType(HttpLambdaHandler.class);
        hints.reflection().registerType(HttpApiV2ProxyRequest.class, hint -> hint.withMembers(
            INVOKE_DECLARED_CONSTRUCTORS,
            INVOKE_PUBLIC_CONSTRUCTORS,
            INVOKE_DECLARED_METHODS,
            INVOKE_PUBLIC_METHODS,
            DECLARED_FIELDS,
            PUBLIC_FIELDS)
        );
    }

}
