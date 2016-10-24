package fr.paris10.td4.base;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * POA_Patterns
 * Copyright (C) 2016 lomhillah and pascalpoizat (@lhillah, @pascalpoizat)
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

public class Directory extends AbstractFile {

    private Map<Integer, File> contents;

    public Directory(String name, String username) {
        super(name, username);
        this.contents = new HashMap<>();
    }

    private File add(File f) {
        return contents.put(f.getId(), f);
    }

    private File remove(File f) {
        return contents.remove(f.getId());
    }

    public File getById(Integer fileId) {
        return contents.get(fileId);
    }

    public File getByName(String fileName) {
        return contents.values().stream()
                .filter(f -> f.getName().equals(fileName))
                .findAny()
                .orElse(null);
    }

    @Override
    public String toString() {
        return String.format("(d)%s [%s]",
                super.toString(),
                contents.values().stream()
                        .map(f -> f.toString())
                        .collect(Collectors.joining("\n")));
    }

    @Override
    public String read() {
        if (getMode() == OpenMode.READ) {
            return contents.values().stream()
                    .map(f -> f.toString())
                    .collect(Collectors.joining("\n"));
        } else {
            return null;
        }
    }

    @Override
    public boolean write(String content) {
        if (getMode() == OpenMode.WRITE) {
            contents.clear();
            File file = new OrdinaryFile(content, getUser().getUid());
            add(file);
            return true;
        } else if (getMode() == OpenMode.APPEND) {
            File file = new OrdinaryFile(content, getUser().getUid());
            add(file);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        return contents.size();
    }
}
