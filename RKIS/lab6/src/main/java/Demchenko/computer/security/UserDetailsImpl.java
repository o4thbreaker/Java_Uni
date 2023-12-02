package Demchenko.computer.security;

import java.util.Collection;
import java.util.Collections;

import Demchenko.computer.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Реализация интерфейса UserDetailsImpl для пользователя системы
 */
public class UserDetailsImpl implements UserDetails {
    /**
     * Объект пользователя системы
     */
    private final User user;

    /**
     * Конструктор для UserDetailsImpl.
     * @param shopUser Пользователь магазина.
     */
    public UserDetailsImpl(User shopUser) {
        this.user = shopUser;
    }

    /**
     * Получает статусы пользователей
     * @return набор статусов пользователя
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(user.getStatus()));
    }

    /**
     * Получает пароль пользователя
     * @return пароль
     */
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    /**
     * Получает имя пользователя
     * @return имя пользователя
     */
    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    /**
     * Получает объект пользователя системы
     * @return Объект пользователя системы
     */
    public User getUser() {
        return user;
    }
}
