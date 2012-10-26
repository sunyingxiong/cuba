/*
 * Copyright (c) 2012 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

package com.haulmont.cuba.core.sys.encryption;

import com.haulmont.cuba.core.global.HashDescriptor;
import com.haulmont.cuba.core.global.PasswordHashDescriptor;
import com.haulmont.cuba.security.entity.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;

/**
 * @author artamonov
 * @version $Id$
 */
public class Md5EncryptionModule implements EncryptionModule {

    @Override
    public HashDescriptor getHash(String content) {
        return new HashDescriptor(DigestUtils.md5Hex(content), null);
    }

    @Override
    public String getHash(String content, String salt) {
        return DigestUtils.md5Hex(content);
    }

    @Override
    public String getPlainHash(String content) {
        return DigestUtils.md5Hex(content);
    }

    @Override
    public HashDescriptor getPasswordHash(String content) {
        HashDescriptor hash = getHash(content);
        return new PasswordHashDescriptor(hash, hash.getHash());
    }

    @Override
    public boolean checkUserAccess(User user, String givenPassword) {
        return StringUtils.equals(user.getPassword(), givenPassword);
    }
}