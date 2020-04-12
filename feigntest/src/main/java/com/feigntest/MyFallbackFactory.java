package com.feigntest;

import feign.hystrix.FallbackFactory;

public class MyFallbackFactory implements FallbackFactory<MyFeign> {
    @Override
    public MyFeign create(Throwable throwable) {
        throwable.getMessage();
        return new MyFeign() {
            @Override
            public String get() {
                return null;
            }
        };
    }
}
