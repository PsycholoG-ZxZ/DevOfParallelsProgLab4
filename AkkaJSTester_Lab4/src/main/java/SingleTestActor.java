import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class SingleTestActor extends AbstractActor{
    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(ClassForTest.class, m -> {
                    ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
                    engine.eval(m.jsScript);
                    Invocable invocable = (Invocable) engine;
                    sender().tell(new ClassForTest())
                })
                .build();
    }

}
