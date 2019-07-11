package app.jirah.parent.di.scopes

import javax.inject.Qualifier

/**
 * Created by Ramiz Raja on 2019-06-19
 */
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.VALUE_PARAMETER,
    AnnotationTarget.ANNOTATION_CLASS,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY)
annotation class UnAuthorized