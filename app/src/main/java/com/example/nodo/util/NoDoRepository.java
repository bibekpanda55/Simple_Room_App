package com.example.nodo.util;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.nodo.data.NoDoDao;
import com.example.nodo.data.NoDoRoomDatabase;
import com.example.nodo.model.NoDo;

import java.util.List;

public class NoDoRepository {

    private NoDoDao noDoDao;
    private  LiveData<List<NoDo>> allNoDos;
    public NoDoRepository(Application application) {

        NoDoRoomDatabase db= NoDoRoomDatabase.getDatabase(application);

        noDoDao=db.noDoDao();
        allNoDos=noDoDao.getAllNoDos();
    }

    public LiveData<List<NoDo>> GetAllNodos()
    {
        return allNoDos;

    }

    public void insert(NoDo nodo)
    {
        new insertAsyncTask(noDoDao).execute(nodo);
    }


    private class insertAsyncTask extends AsyncTask<NoDo,Void,Void> {
        private NoDoDao asyncTaskDao;
        public insertAsyncTask(NoDoDao dao) {

            asyncTaskDao=dao;
        }

        @Override
        protected Void doInBackground(NoDo... params) {
            asyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
