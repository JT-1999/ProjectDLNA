package com.example.projectdlna;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProviders;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * author : J-T
 * date   : 2021/4/22
 * desc   :
 */
public abstract class BaseActivity<VM extends BaseViewModel, VDB extends ViewDataBinding>
        extends AppCompatActivity {
    /**
     * 获取当前activity布局文件，并初始化我们的binding
     **/
    protected abstract int getContentViewId();

    /**
     * 处理业务逻辑
     **/
    protected abstract void processLogic();

    /**
     * ViewModel
     **/
    protected VM mViewModel;
    /**
     * binding
     **/
    protected VDB binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        //初始化binding
        binding = DataBindingUtil.setContentView(this, getContentViewId());
        //给binding加上感知生命周期，AppCompatActivity就是lifeOwner
        binding.setLifecycleOwner(this);
        //创建ViewModel
        createViewModel();
        processLogic();
    }

    public void createViewModel(){
        if (mViewModel==null){
            Class modelClass;
            //返回直接继承的父类（包含泛型参数）
            Type type=getClass().getGenericSuperclass();
            //如果没有没有实现ParameterizedType接口，即不支持发泛型
            if (type instanceof ParameterizedType){
               // 如果支持泛型，返回表示此类型实际类型参数的Type对象的数组,数组里放的都是对应类型的Class
                modelClass=(Class) ((ParameterizedType) type).getActualTypeArguments()[0];
            } else {
                //如果没有指定泛型参数，则默认使用BaseViewModel
                modelClass = BaseViewModel.class;
            }
            mViewModel = (VM) ViewModelProviders.of(this).get(modelClass);
        }
    }
}
