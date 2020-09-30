package zad1;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.RunnerException;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BenchmarkRunner {

    @State(Scope.Thread)
    public static class MyState {

        @Setup(Level.Trial)
        public void doSetup() {
          university=Main.generateStructure(1,5,10000).get(0);
        }

        @TearDown(Level.Trial)
        public void doTearDown() {
            university = null;
        }


        public University university;
    }

    @Benchmark
    @Fork(value = 1)
    @BenchmarkMode(Mode.SingleShotTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testCopingByConstructor(MyState myState){
        Main.copyByConstructor(myState.university);
    }

    @Benchmark
    @Fork(value = 1)
    @BenchmarkMode(Mode.SingleShotTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testCopingByCloneMethod(MyState myState){
        try {
            Main.copyByCloneMethod(myState.university);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    @Benchmark
    @Fork(value = 1)
    @BenchmarkMode(Mode.SingleShotTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testCopingByExternalLibrary(MyState myState){
        Main.copyByExternalLibrary(myState.university);
    }


    public static void main(String[] args) throws IOException, RunnerException {
        org.openjdk.jmh.Main.main(args);
    }
}
