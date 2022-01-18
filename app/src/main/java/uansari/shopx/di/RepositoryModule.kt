package uansari.shopx.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uansari.shopx.api.FakeStoreAPI
import uansari.shopx.repositories.ApiRepository

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    fun getRepository(fakeStoreAPI: FakeStoreAPI) = ApiRepository(fakeStoreAPI)
}
