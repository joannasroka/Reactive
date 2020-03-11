import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import javax.swing.JFrame;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Observable<Integer> payIn = Observable.fromArray(10, 20, 30, 40).delay(elem -> Observable.timer(elem*7, TimeUnit.MILLISECONDS));
        Observable<Integer> payOut = Observable.fromArray(-10, -10, -20, -10).delay(elem -> Observable.timer(-10*elem, TimeUnit.MILLISECONDS));

        // zad 1
        payIn.mergeWith(payOut).scan((x, y) -> x + y).subscribe(elem -> System.out.println(elem + ", "));

// zad 2
        /*
        Observable<Integer> payInResult = payIn.scan((x, y)->x+y);
        Observable<Integer> payOutResult = payOut.scan((x,y) ->x+y);


        payInResult.zipWith(payOutResult, (x, y)-> x+y).subscribe(elem -> System.out.println(elem +", " ));
/*
        // zad 3
/*
        Observable <Integer> factorial =
                Observable.zip(Observable.fromArray(1,2,3,4,5,6,7,8,9,10),
                        Observable.interval(2, TimeUnit.SECONDS),
                        (value, time) ->value);

        Observable<Integer> factorialResult = factorial.flatMap(elem -> Observable.range(1, elem).reduce((x,y)->x*y).toObservable());
        factorialResult.subscribe(elem -> System.out.println(elem + ","));
*/
        Thread.sleep(30_000);
    }
}
