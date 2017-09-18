import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyDemo {
	
	interface Task{
		void originalMethod(String s);
	}
	
	static class TaskImpl implements Task{
		public void originalMethod(String s){
			System.out.println(s);
		}
	}
	
	static class MyHandler implements InvocationHandler{
		private final Object original;
		
		public MyHandler(Object original){
			this.original = original;
		}
		
		public Object invoke(Object proxy, Method method, Object[] args)
		throws IllegalAccessException,IllegalArgumentException,InvocationTargetException
		{
			System.out.println("Before");
			method.invoke(original, args);
			System.out.println("After");
			return null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TaskImpl original = new TaskImpl();
		MyHandler handler = new MyHandler(original);
		Task task = (Task) Proxy.newProxyInstance(Task.class.getClassLoader(), 
				new Class[]{Task.class}, handler);
		task.originalMethod("Hello");
	}

}
