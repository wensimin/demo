package com.demo.dispatcher;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
	private final static Type[] ALL_TYPE = { Type.a, Type.b, Type.c, Type.d, Type.e, Type.f };
	private final static Integer[] ALL_LEVEL = { 1, 2, 3 };
	private final static Integer REQUEST_NUMBER = 100;
	private final static Integer PARTNER_NUMBER = 100;
	public static List<Request> requests = new ArrayList<>(REQUEST_NUMBER);
	public static List<Partner> partners = new ArrayList<>(PARTNER_NUMBER);

	public static void main(String[] args) {
		Random rd = new Random();
		// init request
		for (int i = 0; i < REQUEST_NUMBER; i++) {
			Request request = new Request();
			Calendar cd = Calendar.getInstance();
			cd.set(Calendar.DAY_OF_WEEK, rd.nextInt(7));
			request.setDate(cd.getTime());
			request.setType(ALL_TYPE[rd.nextInt(ALL_TYPE.length)]);
			// TODO area
			request.setArea("");
			requests.add(request);
		}
		// init partner
		for (int i = 0; i < PARTNER_NUMBER; i++) {
			Partner partner = new Partner();
			partner.setArea("");
			int size = rd.nextInt(4) + 1;
			List<Type> type = new ArrayList<>(size);
			for (int j = 0; j < size; j++) {
				type.add(ALL_TYPE[rd.nextInt(ALL_TYPE.length)]);
			}
			partner.setType(type);
			Map<Type, Integer> level = new HashMap<>(size);
			for (Type t : partner.getType()) {
				level.put(t, ALL_LEVEL[rd.nextInt(ALL_LEVEL.length)]);
			}
			partner.setLevel(level);

			Map<Type, Integer> number = new HashMap<>(size);
			for (Type t : partner.getType()) {
				number.put(t, rd.nextInt(10) + 5);
			}
			partner.setNumber(number);
			partner.setRequests(new ArrayList<>());
			partners.add(partner);
		}
		requests.forEach(Main::dispatcher);
		partners = partners.stream().filter((o -> {
			return o.getRequests().size() > 0;
		})).sorted((a, b) -> {
			return a.getRequests().size() - b.getRequests().size();
		}).collect(Collectors.toList());
		System.out.println(partners);
	}

	/**
	 * ·ÖÅä
	 * 
	 * @param request
	 */
	public static void dispatcher(Request request) {
		Partner o = partners.stream().max((a, b) -> {
			return countParent(a, request) - countParent(b, request);
		}).get();
		o.getRequests().add(request);
		o.getNumber().put(request.getType(), o.getNumber().get(request.getType()) - 1);
	}

	public static int countParent(Partner o, Request request) {
		int count = 0;
		if (o.getType().contains(request.getType())) {
			count += 100;
		} else {
			return 0;
		}
		if (o.getNumber().get(request.getType()) == 0) {
			return 0;
		}
		// level count 20
		count += o.getLevel().get(request.getType()) * 20;
		count -= o.getRequests().size();
		return count;
	}
}
