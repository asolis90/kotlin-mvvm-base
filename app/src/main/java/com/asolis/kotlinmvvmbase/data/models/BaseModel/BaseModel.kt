package com.asolis.kotlinmvvmbase.data.models.BaseModel

import android.os.Bundle
import android.os.Parcelable
import com.asolis.kotlinmvvmbase.data.utils.ModelTypeProvider

/**
 * Created by angelsolis on 12/13/20.
 */
abstract class BaseModel : Parcelable, ModelTypeProvider {

    abstract var actionType: String

    abstract var displayData: Bundle

    override fun getModelType(): Int {
        return -1
    }

    override fun getModelClass(): Class<*> {
        return BaseModel::class.java
    }

    override fun describeContents(): Int {
        return 0
    }
}
