package fr.paris10.td4.base;

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

public class OrdinaryFile extends AbstractFile {

    private StringBuffer contents;

    public OrdinaryFile(String name, String username) {
        super(name, username);
        this.contents = new StringBuffer();
    }

    @Override
    public String toString() {
        return "(f)" + super.toString();
    }

    @Override
    public String read() {
        if (getMode() == OpenMode.READ) {
            return contents.toString();
        } else {
            return null;
        }
    }

    @Override
    public boolean write(String content) {
        if (getMode() == OpenMode.WRITE) {
            this.contents = new StringBuffer(content);
            return true;
        } else if (getMode() == OpenMode.APPEND) {
            this.contents.append(content);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        return contents.length();
    }
}
