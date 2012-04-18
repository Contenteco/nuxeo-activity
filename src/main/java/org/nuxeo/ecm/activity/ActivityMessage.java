/*
 * (C) Copyright 2006-2011 Nuxeo SA (http://nuxeo.com/) and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * (LGPL) version 2.1 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-2.1.html
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * Contributors:
 *     Thomas Roger <troger@nuxeo.com>
 */

package org.nuxeo.ecm.activity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * Immutable object representing an Activity message.
 *
 * @author <a href="mailto:troger@nuxeo.com">Thomas Roger</a>
 * @since 5.5
 */
public final class ActivityMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Serializable activityId;

    private final String actor;

    private final String displayActor;

    private final String displayActorLink;

    private final String verb;

    private final String message;

    private final Date publishedDate;

    private final List<ActivityCommentMessage> comments;

    /**
     * @deprecated since 5.6. Use
     *             {@link ActivityMessage#ActivityMessage(java.io.Serializable, String, String, String, String, String, java.util.Date, java.util.List)}
     *             instead.
     */
    @Deprecated
    public ActivityMessage(Serializable activityId, String message,
            Date publishedDate) {
        this(activityId, null, null, null, null, message, publishedDate, null);
    }

    /**
     * @since 5.6
     */
    public ActivityMessage(Serializable activityId, String actor,
            String displayActor, String displayActorLink, String verb,
            String message, Date publishedDate,
            List<ActivityCommentMessage> comments) {
        this.activityId = activityId;
        this.actor = actor;
        this.displayActor = displayActor;
        this.displayActorLink = displayActorLink;
        this.verb = verb;
        this.message = message;
        this.publishedDate = publishedDate;
        this.comments = comments;
    }

    /**
     * @deprecated since 5.6.
     */
    @Deprecated
    public ActivityMessage(Activity activity, String message) {
        this(activity.getId(), activity.getActor(), activity.getDisplayActor(),
                null, activity.getVerb(), message, activity.getPublishedDate(),
                null);
    }

    public Serializable getActivityId() {
        return activityId;
    }

    /**
     * @since 5.6
     */
    public String getActor() {
        return actor;
    }

    /**
     * @since 5.6
     */
    public String getDisplayActor() {
        return displayActor;
    }

    /**
     * @since 5.6
     */
    public String getDisplayActorLink() {
        return displayActorLink;
    }

    /**
     * @since 5.6
     */
    public String getVerb() {
        return verb;
    }

    public String getMessage() {
        return message;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    /**
     * @since 5.6
     */
    public List<ActivityCommentMessage> getActivityCommentMessages() {
        return comments;
    }

}
