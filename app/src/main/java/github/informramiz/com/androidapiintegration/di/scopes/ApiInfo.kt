package app.jirah.parent.di.scopes

import javax.inject.Qualifier

/**
 * Created by Ramiz Raja on 2019-06-18
 */
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CONSTRUCTOR,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.VALUE_PARAMETER)
annotation class ApiInfo