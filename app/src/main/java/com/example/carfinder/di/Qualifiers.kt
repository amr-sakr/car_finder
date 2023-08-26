package com.example.carfinder.di

import javax.inject.Qualifier


@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class DefaultDispatcher

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class IoDispatcher

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class MainDispatcher

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class MainImmediateDispatcher

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class MainDispatcherViewModelScoped

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class ApplicationScope

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class ApplicationScopeMainDispatcher

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class ApplicationScopeIoDispatcher

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class ApplicationScopeDefaultDispatcher

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class ViewModelScopeIoDispatcher

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class ViewModelScopeMainDispatcher

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class ViewModelScopeDefaultDispatcher



