package cz.upce.cv01.controller;

import cz.upce.cv01.domain.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

// N+1 Problem - GraphQL provádí zbytečně načítání všech vnořených dotazů
// při použití @BatchMapping GraphQL dávkuje volání vnořeného dotazu (neprovádí pro každý záznam zvlášť, ale najednou)
// @BatchMapping má být deklarován tak, že jako parametr bere List objektů vnějšího dotazu a vrací Mapu, kde klíč je
// objekt vnějšího dotazu a hodnota je List vnitřního dotazu

// GraphQL subscription
// Subscriptions are what GraphQL employs to deliver real-time updates from the GraphQL server to the subscribed clients.
// client odesílá query nebo mutation a dostává response od serveru
// anotace @withSubscription
// příklad - vkládání příspěvků do nějakého fora a komentářů k příspěvkům
// WebSocket - otevře obousměrnou interaktivní komunickaci mezí klientem a serverem


@Controller
public class AppUserQLController {

    private final AppUserService appuserService;

    @Autowired
    public AppUserQLController(AppUserService appuserService) {
        this.appuserService = appuserService;
    }

    @QueryMapping
    public AppUser getUser(@Argument Long id) {
        return appuserService.findById(id).get();
    }

}
