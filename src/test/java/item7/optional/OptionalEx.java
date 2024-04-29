package item7.optional;

import java.util.Optional;
import org.example.item7.optional.Channel;
import org.example.item7.optional.Membership;
import org.junit.jupiter.api.Test;

class OptionalEx {

    @Test
    void npe() {

        Channel channel = new Channel();
        Membership membership = channel.makeNullableMembership();
        membership.hello();
    }

    @Test
    void npe2() {

        Channel channel = new Channel();
        Membership membership = channel.makeNullableMembership();

        if (membership != null) {
            membership.hello();
        }
    }

    @Test
    void optional() {

        Channel channel = new Channel();
        Optional<Membership> optionalMembership = channel.makeOptionalMembership();
        optionalMembership.ifPresent(Membership::hello);
    }

    @Test
    void test() {

        Channel channel = new Channel();
        channel.test(null);
    }
}
