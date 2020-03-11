import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicInteger;


public class UIReac extends JFrame {

    public UIReac() {
        super("UI React");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(100, 100);

        AtomicInteger clicksCount = new AtomicInteger();
        JButton click = new JButton("Click me");
        add(click);
        JTextArea counter = new JTextArea("0");
        add(counter);

        Observable<ActionEvent> clickObservable = Observable.create(source -> { // to mowi jak sa produkowane dane w zrodle
            click.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    source.onNext(e);                             // a tutaj powiadamiany subskrybenta, ze mamy wartosc
                }
            });
        });



        clickObservable.subscribe(e -> {                // a tutaj co ten subskrybent na te dostana wartosc AE robi
            clicksCount.addAndGet(1);
            counter.setText(""+clicksCount);
        });

    }
}



