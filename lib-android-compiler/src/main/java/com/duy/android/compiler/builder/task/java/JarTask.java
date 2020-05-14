package com.duy.android.compiler.builder.task.java;

import android.util.Log;

import com.android.annotations.Nullable;
import com.duy.android.compiler.builder.IBuilder;
import com.duy.android.compiler.builder.internal.jar.JarArchive;
import com.duy.android.compiler.builder.internal.jar.JarOptions;
import com.duy.android.compiler.builder.task.Task;
import com.duy.android.compiler.project.JavaProject;

import java.io.File;
import java.util.Objects;

import static com.duy.android.compiler.builder.BuildConstants.DOT_JAR;
import static com.duy.android.compiler.builder.BuildConstants.FD_JAR;

public class JarTask extends Task<JavaProject> {
    @Nullable
    private JarOptions mJarOptions;

    public JarTask(IBuilder<JavaProject> builder) {
        super(builder);
    }

    public JarTask(IBuilder<JavaProject> builder, JarOptions jarOptions) {
        super(builder);
        mJarOptions = jarOptions;
    }

    @Override
    public String getTaskName() {
        return "Create jar archive";
    }


    //TODO SHUVOJIT
    @Override
    public boolean doFullTaskAction() throws Exception {
        //now create normal jar file

        Log.d("Shuvojit", "doFullTaskAction: "+mBuilder.isVerbose());

        JarArchive jarArchive = new JarArchive(mBuilder.isVerbose());
        if(mJarOptions!=null){
            Log.d("Shuvojit", "mJarOptions: is not null ");
            jarArchive.setJarOptions(mJarOptions);
        }


        File outputFile = new File(mProject.getDirBuildOutput(), FD_JAR + File.separator + mProject.getProjectName() + DOT_JAR);
        jarArchive.setOutputFile(outputFile);


        if(mProject!=null){
            Log.d("Shuvojit", "mProject: is not null ");

        }

        Log.d("Shuvojit", "outputFile:  "+outputFile.getPath().toString());
        jarArchive.createJarArchive(mProject);

        Log.d("Shuvojit", "createJarArchive:  created");
        if (getBuilder().isVerbose()) {
            getBuilder().stdout("Output jar archive: " + outputFile.getPath());
        }
        return true;
    }

    public void setJarOptions(JarOptions jarOptions) {
        this.mJarOptions = jarOptions;
    }
}