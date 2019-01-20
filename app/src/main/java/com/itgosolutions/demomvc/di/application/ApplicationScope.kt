package com.itgosolutions.demomvc.di.application

import javax.inject.Scope

/**
 * Custom scope for global application singletons
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ApplicationScope {
}