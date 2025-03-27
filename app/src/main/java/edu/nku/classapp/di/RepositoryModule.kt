package edu.nku.classapp.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import edu.nku.classapp.data.repository.RickAndMortyRepository
import edu.nku.classapp.data.repository.RickAndMortyRepositoryReal
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindRickAndMortyRepository(
        rickAndMortyRepositoryReal: RickAndMortyRepositoryReal
    ): RickAndMortyRepository
}