package fr.paris10.td4.base;

import java.util.HashSet;
import java.util.Set;

/**
 * POA_Patterns
 * Copyright (C) 2016 lomhillah (@lhillah)
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

public class UserRegistry {

        public class User {

            private String uid;

            public User(String uid) {
                this.uid = uid;
            }

            public String getUid() {
                return uid;
            }

            @Override
            public String toString() {
                return uid;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                User user = (User) o;

                return uid.equals(user.uid);
            }

            @Override
            public int hashCode() {
                return uid.hashCode();
            }
        }

    private static Set<User> uids;
    private static UserRegistry registry = new UserRegistry();

    public UserRegistry() {
        uids = new HashSet<>();
    }

    public boolean createUser(String uid) {
        return uids.add(new User(uid));
    }

    public boolean removeUser(String uid) {
        return uids.remove(new User(uid));
    }

    public boolean containsUser(String uid) {
        return uids.contains(new User(uid));
    }

    public User get(String uid) {
        if (containsUser(uid)) {
            return new User(uid);
        } else {
            return null;
        }
    }

    public User getAndCreateIfNeeded(String uid) {
        User rtr;
        if (!containsUser(uid)) {
            createUser(uid);
        }
        rtr = get(uid);
        return rtr;
    }

}
