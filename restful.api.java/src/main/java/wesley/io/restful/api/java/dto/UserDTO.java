package wesley.io.restful.api.java.dto;

import wesley.io.restful.api.java.domain.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public record UserDTO(
        String name,
        AccountDTO account,
        CardDTO card,
        List<BaseItemDTO> features,
        List<BaseItemDTO> news
) {

    public User toUser() {
        User user = new User();
        user.setName(name);
        user.setAccount(buildAccount());
        user.setCard(buildCard());
        user.setFeatures(buildFeatures());
        user.setNews(buildNews());
        return user;
    }

    private Account buildAccount() {
        Account accountTo = new Account();
        accountTo.setAccountNumber(account.accountNumber());
        accountTo.setAccountLimit(account.accountLimit());
        accountTo.setBalance(account.balance());
        accountTo.setAgency(account.agency());
        return accountTo;
    }

    private Card buildCard() {
        Card cardTo = new Card();
        cardTo.setCardNumber(card.cardNumber());
        cardTo.setCardLimit(card.cardLimit());
        return cardTo;
    }

    private List<Feature> buildFeatures() {
        return features.stream()
                .map(this::mapBaseItemToFeature)
                .collect(Collectors.toList());
    }

    private Feature mapBaseItemToFeature(BaseItemDTO baseItemDTO) {
        Feature feature = new Feature();
        feature.setIcon(baseItemDTO.icon());
        feature.setDescription(baseItemDTO.description());
        return feature;
    }

    private List<News> buildNews() {
        return news.stream()
                .map(this::mapBaseItemToNews)
                .collect(Collectors.toList());
    }

    private News mapBaseItemToNews(BaseItemDTO baseItemDTO) {
        News news = new News();
        news.setIcon(baseItemDTO.icon());
        news.setDescription(baseItemDTO.description());
        return news;
    }
}
