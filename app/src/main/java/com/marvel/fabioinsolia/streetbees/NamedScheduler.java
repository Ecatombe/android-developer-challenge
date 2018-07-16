package com.marvel.fabioinsolia.streetbees;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Qualifier @Documented @Retention(RUNTIME) public @interface NamedScheduler {

  SchedulerType value() default SchedulerType.IO;

  enum SchedulerType {
    IO, UI
  }
}
