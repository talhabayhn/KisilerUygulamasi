package com.example.kisileruygulamasi.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kisileruygulamasi.data.datasource.KisilerDataSource
import com.example.kisileruygulamasi.data.repo.KisilerRepository
import com.example.kisileruygulamasi.room.KisilerDao
import com.example.kisileruygulamasi.room.VeriTabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    // kisiler repository kisiler data sourcesi kullanıyor
    @Provides
    @Singleton
    fun provideKisilerDataSource(kdao:KisilerDao):KisilerDataSource{
        return KisilerDataSource(kdao)
    }

    //viewmodeller repository istiyor
    @Provides
    @Singleton
    fun provideKisilerRepository(kds:KisilerDataSource):KisilerRepository{
        return KisilerRepository(kds)
    }

    @Provides // dao için beslemeyi sağlayacak
    @Singleton
    fun provideKisilerDao(@ApplicationContext context: Context):KisilerDao{
        val vt = Room.databaseBuilder(context,VeriTabani::class.java,"rehber.sqlite")
            .createFromAsset("rehber.sqlite").build()
        return vt.getKisilerDao()
    }
}