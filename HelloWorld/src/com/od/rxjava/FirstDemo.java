package com.od.rxjava;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscription;

public class FirstDemo {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("jack", "alan", "scott");

//		Observable<Long> interval = Observable.interval(100L, TimeUnit.MILLISECONDS);
		// ConnectableObservable<Long> published = interval.publish();
		// ConnectableObservable<Long> published = interval.replay();
		// Subscription sub1 = subscribePrint(published, "First");
		// Subscription sub2 = subscribePrint(published, "Second");
		// published.connect();
		// Subscription sub3 = null;
		// try {
		// Thread.sleep(500L);
		// sub3 = subscribePrint(published, "Third");
		// Thread.sleep(500L);
		// } catch (InterruptedException e) {
		// }
		// sub1.unsubscribe();
		// sub2.unsubscribe();
		// sub3.unsubscribe();

		// Observable<Long> refCount = interval.publish().refCount();
		// Subscription sub1 = subscribePrint(refCount, "First");
		// Subscription sub2 = subscribePrint(refCount, "Second");
		// try {
		// Thread.sleep(300L);
		// } catch (InterruptedException e) {
		// }
		// sub1.unsubscribe();
		// sub2.unsubscribe();
		// Subscription sub3 = subscribePrint(refCount, "Third");
		// try {
		// Thread.sleep(300L);
		// } catch (InterruptedException e) {
		// }
		// sub3.unsubscribe();
		
		
		
		///////////////////////////////////////////
//		Observable<Long> interval = Observable.interval(100L, TimeUnit.MILLISECONDS); // (1)
//		Subject<Long, Long> publishSubject = PublishSubject.create(); // (2)
//		interval.subscribe(publishSubject);
//		// (3)
//		Subscription sub1 = subscribePrint(publishSubject, "First");
//		Subscription sub2 = subscribePrint(publishSubject, "Second");
//		Subscription sub3 = null;
//		try {
//			Thread.sleep(300L);
//			publishSubject.onNext(555L); // (4)
//			sub3 = subscribePrint(publishSubject, "Third"); // (5)
//			Thread.sleep(500L);
//		} catch (InterruptedException e) {
//		}
//		sub1.unsubscribe(); // (6)
//		sub2.unsubscribe();
//		sub3.unsubscribe();
//		
//		subscribePrint(publishSubject, "fourth");
//		try {
//			Thread.sleep(300L);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		///////////////////////////////////////////
//		Observable<Long> interval = Observable.interval(100L, TimeUnit.MILLISECONDS); // (1)
//		Subject<Long, Long> replaySubject = ReplaySubject.create(); // (2)
//		Subject<Long, Long> replaySubject = BehaviorSubject.create(); // (2)
//		Subject<Long, Long> replaySubject = AsyncSubject.create(); // (2)
//		interval.subscribe(replaySubject);
//		// (3)
//		Subscription sub1 = subscribePrint(replaySubject, "First");
//		Subscription sub2 = subscribePrint(replaySubject, "Second");
//		Subscription sub3 = null;
//		try {
//			Thread.sleep(300L);
//			replaySubject.onNext(555L); // (4)
//			sub3 = subscribePrint(replaySubject, "Third"); // (5)
//			Thread.sleep(500L);
//		} catch (InterruptedException e) {
//		}
//		sub1.unsubscribe(); // (6)
//		sub2.unsubscribe();
//		sub3.unsubscribe();
//		
//		subscribePrint(replaySubject, "fourth");
//		try {
//			Thread.sleep(300L);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
//		Observable<Long> zip = Observable.zip(Observable.just(1L, 3L, 4L), Observable.just(5L, 2L, 6L), (a, b) -> a + b);
//		subscribePrint(zip, "Simple zip");
		
//		Observable<String> timedZip = Observable.zip(Observable.from(Arrays.asList("Z", "I", "P", "P")), Observable.interval(300L, TimeUnit.MILLISECONDS), (
//				value, i) -> value);
//		Observable<String> timedZip = Observable.from(Arrays.asList("Z", "I", "P", "P")).zipWith(Observable.interval(300L, TimeUnit.MILLISECONDS),
//				(value, skip) -> value);
//		subscribePrint1(timedZip, "Timed zip");
		
		Observable<Object> greetings = Observable.just("Hello", "Hi", "Howdy", "Zdravei", "Yo", "Good to see ya").zipWith(
				Observable.interval(1L, TimeUnit.SECONDS), FirstDemo::onlyFirstArg);

		Observable<Object> names = Observable.just("Meddle", "Tanya", "Dali", "Joshua").zipWith(Observable.interval(1500L, TimeUnit.MILLISECONDS),
				FirstDemo::onlyFirstArg);
		
		Observable<Object> punctuation = Observable.just(".", "?", "!", "!!!", "...").zipWith(Observable.interval(1100L, TimeUnit.MILLISECONDS),
				FirstDemo::onlyFirstArg);

		Observable<String> combined = Observable.combineLatest(greetings, names, punctuation, (greeting, name, puntuation) -> greeting + " " + name
				+ puntuation);
		
//		subscribePrint1(combined, "Sentences");
		
		Observable<Object> merged = Observable
				.merge(greetings, names, punctuation);
//		subscribePrint2(merged, "Words");
		
//		Observable<Object> concat = Observable
//				.concat(greetings, names, punctuation);
//				subscribePrint2(concat, "Concat");
				
//		Observable<Object> concat = punctuation.startWith(greetings).startWith(names);
//		subscribePrint2(concat, "Concatenated");
		
//		Observable<String> words = Observable.just("Some", "Other");
//		Observable<Long> interval = Observable
//		.interval(500L, TimeUnit.MILLISECONDS)
//		.take(2);
//		subscribePrint2(Observable.amb(words, interval), "Amb 1");
		
//		Random r = new Random();
//		Observable<String> source1 = Observable
//		.just("data from source 1")
//		.delay(r.nextInt(1000), TimeUnit.MILLISECONDS);
//		Observable<String> source2 = Observable
//		.just("data from source 2")
//		.delay(r.nextInt(1000), TimeUnit.MILLISECONDS);
//		subscribePrint2(Observable.amb(source1, source2), "Amb 2");
		
//		Observable<String> words = Observable // (1)
//				.just("one", "way", "or", "another", "I'll", "learn", "RxJava")
//				.zipWith(Observable.interval(200L, TimeUnit.MILLISECONDS), (x, y) -> x);
//		
//		Observable<Long> interval = Observable.interval(500L, TimeUnit.MILLISECONDS);
//		
//		subscribePrint1(words.takeUntil(interval), "takeUntil"); // (2)
//		subscribePrint1( // (3)
//				words.takeWhile(word -> word.length() > 2), "takeWhile");
//		subscribePrint1(words.skipUntil(interval), "skipUntil"); // (4)
		
		Observable<Long> numbers = Observable
				.just("1", "2", "three", "4", "5")
				.map(Long::parseLong)
				.onErrorReturn(e -> -1L);
		subscribePrint(numbers, "Error returned");
		
		
		
		
		
		
		
		
		
		
		
		
		try {
			Thread.sleep(50000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}

	static Subscription subscribePrint2(Observable<Object> observable, String name) {
		return observable.subscribe((v) -> {System.out.println(name + " : " + v);}, (e) -> {
			System.err.println("Error from " + name + ":");
			System.err.println(e.getMessage());
		}, () -> System.out.println(name + " ended!"));
	}
	
	static Subscription subscribePrint1(Observable<String> observable, String name) {
		return observable.subscribe((v) -> {System.out.println(name + " : " + v);}, (e) -> {
			System.err.println("Error from " + name + ":");
			System.err.println(e.getMessage());
		}, () -> System.out.println(name + " ended!"));
	}
	
	static Subscription subscribePrint(Observable<Long> observable, String name) {
		return observable.subscribe((v) -> {System.out.println(name + " : " + v);}, (e) -> {
			System.err.println("Error from " + name + ":");
			System.err.println(e.getMessage());
		}, () -> System.out.println(name + " ended!"));
	}
	
	public static <T, R> T onlyFirstArg(T arg1, R arg2) {
		return arg1;
	}
}
