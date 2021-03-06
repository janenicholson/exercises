import java.util.Collection;

import com.google.common.collect.Lists;

import lombok.Getter;

@Getter
public class Library {
    private final Collection<Title> collection = Lists.newArrayList();
    private final Collection<Title> newTitles = Lists.newArrayList();

    public void receiveDonation(Title title, Member member, EmailAlert emailAlert) {
        collection.add(title);
        newTitles.add(title);
        title.registerForCheckout(emailAlert);
        member.awardPoints(10);
    }

}
