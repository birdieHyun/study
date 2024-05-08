package org.example.item7.optional;

import java.util.Optional;
import lombok.Getter;

@Getter
public class Channel {

    private int numOfSubscribers;

    public Membership makeNullableMembership() {
        if (numOfSubscribers < 200) {
            return null;
        }

        return new Membership();
    }

    public Optional<Membership> makeOptionalMembership() {
        if (numOfSubscribers < 200) {
            return Optional.empty();
        }

        return Optional.of(new Membership());
    }

    public String optionalParameter(Optional<Object> object) {

        return object.map(Object::toString).orElse("empty");
    }
}
