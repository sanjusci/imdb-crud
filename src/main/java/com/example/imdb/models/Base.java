/**
 *
 * @author  Sanjeev Kumar
 * @version 1.0
 * @since   2019-Aug-12
 */

package com.example.imdb.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * The type Base.
 */
@Document
public abstract class Base implements Serializable {

    /**
     * The Id.
     */
    @Id
    protected ObjectId _id;

    /**
     * The Created date.
     */
    @CreatedDate
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    protected Date created_date;

    /**
     * The Updated date.
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    protected Date updated_date;

    /**
     * The Is deleted.
     */
    @Indexed
    protected int is_deleted;

    /**
     * The Updated by.
     */
    protected String updated_by;

    /**
     * The Created by.
     */
    protected String created_by;

    /**
     * The Is active.
     */
    @Indexed
    protected String is_active;

    /**
     * Gets is active.
     *
     * @return the is active
     */
    public String getIs_active() {
        return is_active;
    }

    /**
     * Sets is active.
     *
     * @param is_active the is active
     */
    public void setIs_active(String is_active) {
        this.is_active = is_active;
    }

    /**
     * Gets created by.
     *
     * @return the created by
     */
    public String getCreated_by() {
        return created_by;
    }

    /**
     * Sets created by.
     *
     * @param created_by the created by
     */
    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    /**
     * Gets updated by.
     *
     * @return the updated by
     */
    public String getUpdated_by() {
        return updated_by;
    }

    /**
     * Sets updated by.
     *
     * @param updated_by the updated by
     */
    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }

    /**
     * Gets created date.
     *
     * @return the created date
     */
    public Date getCreated_date() {
        return created_date;
    }

    /**
     * Sets created date.
     *
     * @param created_date the created date
     */
    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    /**
     * Gets updated date.
     *
     * @return the updated date
     */
    public Date getUpdated_date() {
        return updated_date;
    }

    /**
     * Sets updated date.
     *
     * @param updated_date the updated date
     */
    public void setUpdated_date(Date updated_date) {
        this.updated_date = updated_date;
    }

    /**
     * Gets is deleted.
     *
     * @return the is deleted
     */
    public int getIs_deleted() {
        return is_deleted;
    }

    /**
     * Sets is deleted.
     *
     * @param is_deleted the is deleted
     */
    public void setIs_deleted(int is_deleted) {
        this.is_deleted = is_deleted;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String get_id() {
        return _id.toHexString();
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void set_id(ObjectId id) {
        this._id = id;
    }

}
