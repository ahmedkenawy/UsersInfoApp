package com.ahmedkenawy.user.di
import android.content.Context
import androidx.room.Room
import com.ahmedkenawy.user.data.local.database.UserDatabase
import com.ahmedkenawy.user.util.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Dagger Hilt module that provides the UserDatabase instance.
 *
 * The @Module annotation tells Dagger that this is a Dagger module.
 * The @InstallIn annotation specifies the component in which the module will be installed.
 */
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    /**
     * Provides a singleton instance of UserDatabase.
     *
     * @param context The application context used for creating the database.
     * @return A UserDatabase instance for accessing the user database.
     */
    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): UserDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            UserDatabase::class.java,
            DATABASE_NAME
        ).build()
    }
}
