/*
 * Copyright (C) 2007-2010 Júlio Vilmar Gesser.
 * Copyright (C) 2011, 2013-2016 The JavaParser Team.
 *
 * This file is part of JavaParser.
 * 
 * JavaParser can be used either under the terms of
 * a) the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 * b) the terms of the Apache License 
 *
 * You should have received a copy of both licenses in LICENCE.LGPL and
 * LICENCE.APACHE. Please refer to those files for details.
 *
 * JavaParser is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 */
 
package com.github.javaparser.ast.expr;

import com.github.javaparser.Range;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;

import java.util.Optional;

import static com.github.javaparser.utils.Utils.assertNotNull;
import static com.github.javaparser.utils.Utils.none;

/**
 * @author Julio Vilmar Gesser
 */
public final class EnclosedExpr extends Expression {

	private Optional<Expression> inner;

	public EnclosedExpr() {
        this(Range.UNKNOWN, none());
	}

	public EnclosedExpr(final Optional<Expression> inner) {
		this(Range.UNKNOWN, inner);
	}

	public EnclosedExpr(final Range range, final Optional<Expression> inner) {
		super(range);
		setInner(inner);
	}

	@Override public <R, A> R accept(final GenericVisitor<R, A> v, final A arg) {
		return v.visit(this, arg);
	}

	@Override public <A> void accept(final VoidVisitor<A> v, final A arg) {
		v.visit(this, arg);
	}

	public Optional<Expression> getInner() {
		return inner;
	}

	public EnclosedExpr setInner(final Optional<Expression> inner) {
		this.inner = assertNotNull(inner);
		setAsParentNodeOf(this.inner);
		return this;
	}
}
